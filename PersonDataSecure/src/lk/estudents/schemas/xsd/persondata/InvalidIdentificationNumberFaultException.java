
/**
 * InvalidIdentificationNumberFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package lk.estudents.schemas.xsd.persondata;

public class InvalidIdentificationNumberFaultException extends java.lang.Exception{
    
    private lk.estudents.schemas.xsd.persondata.InvalidIdentificationNumberFault faultMessage;

    
        public InvalidIdentificationNumberFaultException() {
            super("InvalidIdentificationNumberFaultException");
        }

        public InvalidIdentificationNumberFaultException(java.lang.String s) {
           super(s);
        }

        public InvalidIdentificationNumberFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public InvalidIdentificationNumberFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(lk.estudents.schemas.xsd.persondata.InvalidIdentificationNumberFault msg){
       faultMessage = msg;
    }
    
    public lk.estudents.schemas.xsd.persondata.InvalidIdentificationNumberFault getFaultMessage(){
       return faultMessage;
    }
}
    