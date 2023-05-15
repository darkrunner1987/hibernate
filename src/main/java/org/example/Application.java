package org.example;

import org.example.repository.DocumentRepository;
import org.example.repository.PersonRepository;
import org.example.service.PersonDocumentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner output(
            PersonRepository personRepository,
            DocumentRepository documentRepository,
            PersonDocumentService personDocumentService
    ) {
        return args -> {
//            System.out.printf("Person: %s%n", personRepository.get(1));
//            System.out.printf("Document: %s%n", documentRepository.get(1));

            var docsMap = personDocumentService.getPersonActiveDocumentsWith777();
            docsMap.forEach((person, docs) ->
                    docs.forEach(doc ->
                            System.out.printf("%s: %s %s\n", person.getName(), doc.getType(), doc.getNumber())));
        };
    }
}