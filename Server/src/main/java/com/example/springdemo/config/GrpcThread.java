package com.example.springdemo.config;

import com.example.springdemo.services.MedicationDispenserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;


public class GrpcThread extends Thread {
     Server server;

    public GrpcThread(MedicationDispenserService medicationDispenserService) {
        System.out.println("Tristete2");
        this.server = ServerBuilder.forPort(8081)
                .addService(medicationDispenserService)
                .build();
    }

    @Override
    public void run() {
        try {
            System.out.println("Merge grpc");
            server.start();
            System.out.println("Merge grpc");
            server.awaitTermination();
        } catch (Exception e) {
            System.out.println("Tot ce simt acum este tristete");
        }
    }
}
