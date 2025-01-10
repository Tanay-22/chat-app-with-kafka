//package com.tanay.chat_app_with_kafka.controller;
//
//
//import com.tanay.chat_app_with_kafka.model.Message;
//import com.tanay.chat_app_with_kafka.service.KafkaConsumerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//
//import java.time.Duration;
//import java.util.Objects;
//import java.util.stream.Stream;
//
//@RestController
//public class SSEController
//{
//
//    private final KafkaConsumerService consumerService;
//
//    @Autowired
//    public SSEController(KafkaConsumerService consumerService)
//    {
//        this.consumerService = consumerService;
//    }
//
//    @GetMapping(value = "/api/messages/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Message> streamMessages()
//    {
//        return Flux.interval(Duration.ofSeconds(1))
//                .flatMap(tick ->
//                        Flux.fromStream(Stream.generate(() ->
//                                consumerService.getMessageQueue()
//                                        .poll())
//                                .limit(1)))
//                .filter(Objects::nonNull);
//    }
//}
