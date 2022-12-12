import java.io.*;
import java.net.*;

public class ClientIOTest {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6666);

            Student st = new Student();
            st.firstName = "John";
            st.lastName = "Doe";
            st.age = 20;
            st.gpa = 3.5;
            st.dept = new Department[10];
            for (int i = 0; i < st.dept.length; i++) {
                st.dept[i] = new Department();
                st.dept[i].id = i;
                st.dept[i].name = "Dept " + i;
            }

            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Object o = ois.readObject();
            if (o instanceof Student) {
                Student st2 = (Student) o;
            }

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(st.firstName);
            dos.writeUTF(st.lastName);
            dos.writeInt(st.age);
            dos.writeDouble(st.gpa);
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}