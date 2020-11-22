package com.bptopenware.messages.api;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import com.bptopenware.messages.grpc.I18Next;
import com.bptopenware.messages.grpc.AddUpdateResponse;
import com.bptopenware.messages.grpc.I18NextAPIGrpc;
import com.bptopenware.messages.i18nextrepository.I18NextDTO;
import com.bptopenware.messages.i18nextrepository.I18NextRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * gRPC service for i18Next
 *
 */
@Slf4j
public class I18NextService extends I18NextAPIGrpc.I18NextAPIImplBase {

    @Autowired
    private I18NextRepository repository;

    @Override
    public void getMessages(I18Next request, StreamObserver<I18Next> responseObserver) {

        try {
            I18NextDTO record = repository.findBySysidAndAppidAndCompidAndLanguageAndNamespace(request.getSysid(), request.getAppid(), 
                                request.getCompid(), request.getLanguage(), request.getNamespace());

            I18Next response = I18Next.newBuilder().setResource(record.getResource())
                                            .setSysid(record.getSysid()).setAppid(record.getAppid())
                                            .setCompid(record.getCompid()).setLanguage(record.getLanguage())
                                            .setNamespace(record.getNamespace()).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

            
        } catch(Exception ex) {

            responseObserver.onError(ex);

            log.error("Error generating response", ex);

        }

    }

    @Override
    public void addMessages(I18Next request, StreamObserver<AddUpdateResponse> responseObserver) {

        try {
            

            I18NextDTO record = new I18NextDTO();
            record.setSysid(request.getSysid());
            record.setAppid(request.getAppid());
            record.setCompid(request.getCompid());
            record.setLanguage(request.getLanguage());
            record.setNamespace(request.getNamespace());
            record.setModID(request.getModID());
            record.setResource(request.getResource());
            
            record = repository.save(record);
            
            AddUpdateResponse response = AddUpdateResponse.newBuilder().setSuccess(true).setResID(record.getResID()).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

            
        } catch(Exception ex) {

            responseObserver.onError(ex);

            log.error("Error generating response", ex);

        }

    } 

    @Override
	public void removeMessages(I18Next request, StreamObserver<AddUpdateResponse> responseObserver) {
        
        try {

            I18NextDTO record = new I18NextDTO();
            
            record.setResID(request.getResID());

            repository.delete(record);

            AddUpdateResponse response = AddUpdateResponse.newBuilder().setSuccess(true).setResID(record.getResID()).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

            
        } catch(Exception ex) {

            responseObserver.onError(ex);

            log.error("Error generating response", ex);

        }

    }

    @Override
	public void updateMessages(I18Next request, StreamObserver<AddUpdateResponse> responseObserver) {
        
        try {

            I18NextDTO record = repository.findBySysidAndAppidAndCompidAndLanguageAndNamespace(request.getSysid(), request.getAppid(), 
                                request.getCompid(), request.getLanguage(), request.getNamespace());

            record = repository.save(record);

            AddUpdateResponse response = AddUpdateResponse.newBuilder().setSuccess(true).setResID(record.getResID()).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

            
        } catch(Exception ex) {

            responseObserver.onError(ex);

            log.error("Error generating response", ex);

        }

    }
	
}
