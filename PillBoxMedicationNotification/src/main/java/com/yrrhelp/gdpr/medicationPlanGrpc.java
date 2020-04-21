package com.yrrhelp.gdpr;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: medicationPlan.proto")
public final class medicationPlanGrpc {

  private medicationPlanGrpc() {}

  public static final String SERVICE_NAME = "medicationPlan";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.yrrhelp.gdpr.MedicationPlan.PlanRequest,
      com.yrrhelp.gdpr.MedicationPlan.PlanResponse> getGetPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPlan",
      requestType = com.yrrhelp.gdpr.MedicationPlan.PlanRequest.class,
      responseType = com.yrrhelp.gdpr.MedicationPlan.PlanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.yrrhelp.gdpr.MedicationPlan.PlanRequest,
      com.yrrhelp.gdpr.MedicationPlan.PlanResponse> getGetPlanMethod() {
    io.grpc.MethodDescriptor<com.yrrhelp.gdpr.MedicationPlan.PlanRequest, com.yrrhelp.gdpr.MedicationPlan.PlanResponse> getGetPlanMethod;
    if ((getGetPlanMethod = medicationPlanGrpc.getGetPlanMethod) == null) {
      synchronized (medicationPlanGrpc.class) {
        if ((getGetPlanMethod = medicationPlanGrpc.getGetPlanMethod) == null) {
          medicationPlanGrpc.getGetPlanMethod = getGetPlanMethod = 
              io.grpc.MethodDescriptor.<com.yrrhelp.gdpr.MedicationPlan.PlanRequest, com.yrrhelp.gdpr.MedicationPlan.PlanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "medicationPlan", "getPlan"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.gdpr.MedicationPlan.PlanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.gdpr.MedicationPlan.PlanResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new medicationPlanMethodDescriptorSupplier("getPlan"))
                  .build();
          }
        }
     }
     return getGetPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.yrrhelp.gdpr.MedicationPlan.MessageRequest,
      com.yrrhelp.gdpr.MedicationPlan.MessageResponse> getPillTakenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pillTaken",
      requestType = com.yrrhelp.gdpr.MedicationPlan.MessageRequest.class,
      responseType = com.yrrhelp.gdpr.MedicationPlan.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.yrrhelp.gdpr.MedicationPlan.MessageRequest,
      com.yrrhelp.gdpr.MedicationPlan.MessageResponse> getPillTakenMethod() {
    io.grpc.MethodDescriptor<com.yrrhelp.gdpr.MedicationPlan.MessageRequest, com.yrrhelp.gdpr.MedicationPlan.MessageResponse> getPillTakenMethod;
    if ((getPillTakenMethod = medicationPlanGrpc.getPillTakenMethod) == null) {
      synchronized (medicationPlanGrpc.class) {
        if ((getPillTakenMethod = medicationPlanGrpc.getPillTakenMethod) == null) {
          medicationPlanGrpc.getPillTakenMethod = getPillTakenMethod = 
              io.grpc.MethodDescriptor.<com.yrrhelp.gdpr.MedicationPlan.MessageRequest, com.yrrhelp.gdpr.MedicationPlan.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "medicationPlan", "pillTaken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.gdpr.MedicationPlan.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.gdpr.MedicationPlan.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new medicationPlanMethodDescriptorSupplier("pillTaken"))
                  .build();
          }
        }
     }
     return getPillTakenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.yrrhelp.gdpr.MedicationPlan.MessageRequest,
      com.yrrhelp.gdpr.MedicationPlan.MessageResponse> getPillNotTakenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pillNotTaken",
      requestType = com.yrrhelp.gdpr.MedicationPlan.MessageRequest.class,
      responseType = com.yrrhelp.gdpr.MedicationPlan.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.yrrhelp.gdpr.MedicationPlan.MessageRequest,
      com.yrrhelp.gdpr.MedicationPlan.MessageResponse> getPillNotTakenMethod() {
    io.grpc.MethodDescriptor<com.yrrhelp.gdpr.MedicationPlan.MessageRequest, com.yrrhelp.gdpr.MedicationPlan.MessageResponse> getPillNotTakenMethod;
    if ((getPillNotTakenMethod = medicationPlanGrpc.getPillNotTakenMethod) == null) {
      synchronized (medicationPlanGrpc.class) {
        if ((getPillNotTakenMethod = medicationPlanGrpc.getPillNotTakenMethod) == null) {
          medicationPlanGrpc.getPillNotTakenMethod = getPillNotTakenMethod = 
              io.grpc.MethodDescriptor.<com.yrrhelp.gdpr.MedicationPlan.MessageRequest, com.yrrhelp.gdpr.MedicationPlan.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "medicationPlan", "pillNotTaken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.gdpr.MedicationPlan.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yrrhelp.gdpr.MedicationPlan.MessageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new medicationPlanMethodDescriptorSupplier("pillNotTaken"))
                  .build();
          }
        }
     }
     return getPillNotTakenMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static medicationPlanStub newStub(io.grpc.Channel channel) {
    return new medicationPlanStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static medicationPlanBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new medicationPlanBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static medicationPlanFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new medicationPlanFutureStub(channel);
  }

  /**
   */
  public static abstract class medicationPlanImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPlan(com.yrrhelp.gdpr.MedicationPlan.PlanRequest request,
        io.grpc.stub.StreamObserver<com.yrrhelp.gdpr.MedicationPlan.PlanResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPlanMethod(), responseObserver);
    }

    /**
     */
    public void pillTaken(com.yrrhelp.gdpr.MedicationPlan.MessageRequest request,
        io.grpc.stub.StreamObserver<com.yrrhelp.gdpr.MedicationPlan.MessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPillTakenMethod(), responseObserver);
    }

    /**
     */
    public void pillNotTaken(com.yrrhelp.gdpr.MedicationPlan.MessageRequest request,
        io.grpc.stub.StreamObserver<com.yrrhelp.gdpr.MedicationPlan.MessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPillNotTakenMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPlanMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.yrrhelp.gdpr.MedicationPlan.PlanRequest,
                com.yrrhelp.gdpr.MedicationPlan.PlanResponse>(
                  this, METHODID_GET_PLAN)))
          .addMethod(
            getPillTakenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.yrrhelp.gdpr.MedicationPlan.MessageRequest,
                com.yrrhelp.gdpr.MedicationPlan.MessageResponse>(
                  this, METHODID_PILL_TAKEN)))
          .addMethod(
            getPillNotTakenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.yrrhelp.gdpr.MedicationPlan.MessageRequest,
                com.yrrhelp.gdpr.MedicationPlan.MessageResponse>(
                  this, METHODID_PILL_NOT_TAKEN)))
          .build();
    }
  }

  /**
   */
  public static final class medicationPlanStub extends io.grpc.stub.AbstractStub<medicationPlanStub> {
    private medicationPlanStub(io.grpc.Channel channel) {
      super(channel);
    }

    private medicationPlanStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected medicationPlanStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new medicationPlanStub(channel, callOptions);
    }

    /**
     */
    public void getPlan(com.yrrhelp.gdpr.MedicationPlan.PlanRequest request,
        io.grpc.stub.StreamObserver<com.yrrhelp.gdpr.MedicationPlan.PlanResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPlanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pillTaken(com.yrrhelp.gdpr.MedicationPlan.MessageRequest request,
        io.grpc.stub.StreamObserver<com.yrrhelp.gdpr.MedicationPlan.MessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPillTakenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pillNotTaken(com.yrrhelp.gdpr.MedicationPlan.MessageRequest request,
        io.grpc.stub.StreamObserver<com.yrrhelp.gdpr.MedicationPlan.MessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPillNotTakenMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class medicationPlanBlockingStub extends io.grpc.stub.AbstractStub<medicationPlanBlockingStub> {
    private medicationPlanBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private medicationPlanBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected medicationPlanBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new medicationPlanBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.yrrhelp.gdpr.MedicationPlan.PlanResponse getPlan(com.yrrhelp.gdpr.MedicationPlan.PlanRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPlanMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.yrrhelp.gdpr.MedicationPlan.MessageResponse pillTaken(com.yrrhelp.gdpr.MedicationPlan.MessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getPillTakenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.yrrhelp.gdpr.MedicationPlan.MessageResponse pillNotTaken(com.yrrhelp.gdpr.MedicationPlan.MessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getPillNotTakenMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class medicationPlanFutureStub extends io.grpc.stub.AbstractStub<medicationPlanFutureStub> {
    private medicationPlanFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private medicationPlanFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected medicationPlanFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new medicationPlanFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.yrrhelp.gdpr.MedicationPlan.PlanResponse> getPlan(
        com.yrrhelp.gdpr.MedicationPlan.PlanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPlanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.yrrhelp.gdpr.MedicationPlan.MessageResponse> pillTaken(
        com.yrrhelp.gdpr.MedicationPlan.MessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPillTakenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.yrrhelp.gdpr.MedicationPlan.MessageResponse> pillNotTaken(
        com.yrrhelp.gdpr.MedicationPlan.MessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPillNotTakenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PLAN = 0;
  private static final int METHODID_PILL_TAKEN = 1;
  private static final int METHODID_PILL_NOT_TAKEN = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final medicationPlanImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(medicationPlanImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PLAN:
          serviceImpl.getPlan((com.yrrhelp.gdpr.MedicationPlan.PlanRequest) request,
              (io.grpc.stub.StreamObserver<com.yrrhelp.gdpr.MedicationPlan.PlanResponse>) responseObserver);
          break;
        case METHODID_PILL_TAKEN:
          serviceImpl.pillTaken((com.yrrhelp.gdpr.MedicationPlan.MessageRequest) request,
              (io.grpc.stub.StreamObserver<com.yrrhelp.gdpr.MedicationPlan.MessageResponse>) responseObserver);
          break;
        case METHODID_PILL_NOT_TAKEN:
          serviceImpl.pillNotTaken((com.yrrhelp.gdpr.MedicationPlan.MessageRequest) request,
              (io.grpc.stub.StreamObserver<com.yrrhelp.gdpr.MedicationPlan.MessageResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class medicationPlanBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    medicationPlanBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.yrrhelp.gdpr.MedicationPlan.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("medicationPlan");
    }
  }

  private static final class medicationPlanFileDescriptorSupplier
      extends medicationPlanBaseDescriptorSupplier {
    medicationPlanFileDescriptorSupplier() {}
  }

  private static final class medicationPlanMethodDescriptorSupplier
      extends medicationPlanBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    medicationPlanMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (medicationPlanGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new medicationPlanFileDescriptorSupplier())
              .addMethod(getGetPlanMethod())
              .addMethod(getPillTakenMethod())
              .addMethod(getPillNotTakenMethod())
              .build();
        }
      }
    }
    return result;
  }
}
