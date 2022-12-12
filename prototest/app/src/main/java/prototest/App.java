/*
 * This Java source file was generated by the Gradle 'init' task.
 */
// package prototest;

public class App {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5555);
        OutputStream os = s.getOutputStream();

        SearchRequest sp = SearchRequest.newBuilder()
                .setQuery("slaw")
                .setUsername("dyary")
                .setUserid(99)
                .build();

        // encoding to byte array
        //byte[] dyary = sp.toByteArray();

        sp.writeTo(os);

        // default (no protobuf): DataOutputStream dos = new DataOutputStream(os);
        // dos.write(sp);

        // below decoding
        ServerSocket ss = new ServerSocket(5555);
        Socket s2 = ss.accept();
        InputStream is = s2.getInputStream();
        // the line below is responsible for the decoding
        SearchRequest sf = SearchRequest.parseFrom(is);
        System.out.println(sf.getQuery());

        // another way for decoding
        // this one not recommeneded

        // byte[] arr2 = new byte[1024];
        // for (byte arr : arr2) {
        //     arr[i] = (byte) is.read();
        // }
        // SearchRequest vf = SearchRequest.parseFrom(arr2);

    }
}