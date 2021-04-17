package org.omg.PortableInterceptor;


/**
* org/omg/PortableInterceptor/PolicyFactory.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /jenkins/workspace/8-2-build-macosx-x86_64/jdk8u281/880/corba/src/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* Wednesday, December 9, 2020 12:45:08 PM GMT
*/


/**
   * Enables policy types to be constructed using 
   * <code>CORBA.ORB.create_policy</code>.
   * <p>
   * A portable ORB service implementation registers an instance of the 
   * <code>PolicyFactory</code> interface during ORB initialization in order 
   * to enable its policy types to be constructed using 
   * <code>CORBA.ORB.create_policy</code>. The POA is required to preserve 
   * any policy which is registered with <code>ORBInitInfo</code> in this 
   * manner.
   *
   * @see ORBInitInfo#register_policy_factory
   */
public interface PolicyFactory extends PolicyFactoryOperations, org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity 
{
} // interface PolicyFactory
