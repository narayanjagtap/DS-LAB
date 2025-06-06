package HelloModule;


/**
* HelloModule/_HelloStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from HelloModule.idl
* Thursday, 18 April, 2024 4:00:12 PM IST
*/

public class _HelloStub extends org.omg.CORBA.portable.ObjectImpl implements HelloModule.Hello
{

  public String print_hello (String s)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("print_hello", true);
                $out.write_string (s);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return print_hello (s        );
            } finally {
                _releaseReply ($in);
            }
  } // print_hello

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:HelloModule/Hello:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     com.sun.corba.se.impl.orbutil.IORCheckImpl.check(str, "HelloModule._HelloStub");
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _HelloStub
