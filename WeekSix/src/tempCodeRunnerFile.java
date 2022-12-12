        while (true) {
            try {
                ServerSocket ss = new ServerSocket(1000);
                Socket s1 = ss.accept();
                Socket s = new Socket("localhost", 2000);

                DataInputStream in = new DataInputStream(s.getInputStream()); // input from terminal
                DataOutputStream out = new DataOutputStream(s.getOutputStream()); // output to socket
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                    out.writeUTF(br.readLine());
                    System.out.println("Server says: " + in.readUTF());

            } catch (IOException e) {
                continue;
            }
        }