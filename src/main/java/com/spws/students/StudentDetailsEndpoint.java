package com.spws.students;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.spws.students.GetStudentDetailsRequest;
import com.spws.students.GetStudentDetailsResponse;
import com.spws.students.StudentDetails;

/**
 * @Endpoint - Annotation to indicate that this is a Web Service Endpoint.
 */
@Endpoint
public class StudentDetailsEndpoint {

    /**
     * @PayloadRoot(namespace = "SPWS.com/students",
     * localPart = "GetStudentDetailsRequest") -
     * Defines the details of the request that this method would handle.
     * We will handle GetStudentDetailsRequest with the given namespace.
     */
    @PayloadRoot(namespace = "SPWS.com/students",localPart = "GetStudentDetailsRequest")
    @ResponsePayload/** @ResponsePayload - This method will return a response which would need to be converted to a response xml.*/
    /**
     * public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request) -
     * Method would handle the request. @RequestPayload indicates that this is got from the request.
     */
    public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request){
        GetStudentDetailsResponse response = new GetStudentDetailsResponse();

        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(request.getId());
        studentDetails.setName( "Tumelo" );
        studentDetails.setIdNumber( "4544554454" );

        response.setStudentDetails( studentDetails );

        return response;
    }
}
