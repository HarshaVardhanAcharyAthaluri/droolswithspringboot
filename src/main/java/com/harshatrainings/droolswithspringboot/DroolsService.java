package com.harshatrainings.droolswithspringboot;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DroolsService {

    @Autowired
    private KieContainer kieContainer;

    public String validatePersons(Map<String, Object> jsonMap) {
        KieSession ksession = kieContainer.newKieSession();
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            String role = entry.getKey();
            Map<String, Object> person = (Map<String, Object>) entry.getValue();
            Map<String, Object> fact = new HashMap<>(person);
            fact.put("role", role);
            ksession.insert(fact);
        }
        ksession.fireAllRules();
        System.out.println( ksession.getQueryResults("role").size());
        ksession.dispose();
        return "Validation complete. Check logs for results.";
    }



}
