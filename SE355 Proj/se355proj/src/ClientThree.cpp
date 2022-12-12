#include <iostream>
#include <netinet/in.h>
#include <sys/socket.h>
#define PORT 2003
using namespace std;


int main() {
  int server_fd, new_socket;
  struct sockaddr_in address;
  int opt = 1;
  int addrlen = sizeof(address);
  int counter;
  int guess;
  int tr;
  string read;

  // Creating socket file descriptor
  if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0) {
    perror("socket failed");
    exit(EXIT_FAILURE);
  }

  // Forcefully attaching socket to the port 8080
  if (setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR, &opt,
                 sizeof(opt))) {
    perror("setsockopt");
    exit(EXIT_FAILURE);
  }

  address.sin_family = AF_INET;
  address.sin_addr.s_addr = INADDR_ANY;
  address.sin_port = htons(PORT);

  // Forcefully attaching socket to the port 8080
  if (::bind(server_fd, (struct sockaddr *)&address, sizeof(address)) < 0) {
    perror("bind failed");
    exit(EXIT_FAILURE);
  }

  if (listen(server_fd, 3) < 0) {
    perror("listen");
    exit(EXIT_FAILURE);
  }

  while(true) {
      if ((new_socket = accept(server_fd, (struct sockaddr *)&address,
                              (socklen_t *)&addrlen)) < 0) {
        perror("accept");
        exit(EXIT_FAILURE);
      }

      // send and receive
      recv(new_socket, &read, sizeof(read), 0);
      cout << read << endl;
      while (counter < 5) {
        cout << "Enter your guess: ";
        cin >> guess;
        send(new_socket, &guess, sizeof(guess), 0);
        counter++;
        recv(new_socket, &read, sizeof(read), 0);
        tr = stoi(read);
        if (tr == -1) {
          return 0;
        }
      }
      
      string win = "I finished in" + to_string(counter) + "guesses";
      send(new_socket, &win, sizeof(win), 0);
  }

  return 0;
}
