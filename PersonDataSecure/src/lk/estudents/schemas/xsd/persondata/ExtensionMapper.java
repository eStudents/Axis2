
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

            package lk.estudents.schemas.xsd.persondata;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://schemas.estudents.lk/xsd/persondata".equals(namespaceURI) &&
                  "InvalidIdentificationNumberFaultType".equals(typeName)){
                   
                            return  lk.estudents.schemas.xsd.persondata.InvalidIdentificationNumberFaultType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://schemas.estudents.lk/xsd/persondata".equals(namespaceURI) &&
                  "PersonDatFaultType".equals(typeName)){
                   
                            return  lk.estudents.schemas.xsd.persondata.PersonDatFaultType.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    