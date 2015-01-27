
/**
 * PersonDataServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
    package lk.estudents.schemas.xsd.persondata;
    /**
     *  PersonDataServiceSkeletonInterface java skeleton interface for the axisService
     */
    public interface PersonDataServiceSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * 
                                    * @param personDataRequest
             * @throws InvalidIdentificationNumberFaultException : 
         */

        
                public lk.estudents.schemas.xsd.persondata.PersonDataResponse getPersonData
                (
                  lk.estudents.schemas.xsd.persondata.PersonDataRequest personDataRequest
                 )
            throws InvalidIdentificationNumberFaultException;
        
         }
    