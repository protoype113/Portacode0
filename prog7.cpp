#include <iostream>
int main() {
    double A = 1; 
    for (int i = 0; i < 5000000; i++) {
        A += 10; 
        for (int i  = 0; i < 5; i++) {
             for (int i  = 0; i < 5; i++) {
                A += 1;
             }
        }
        A += 1;
    }
    std::cout << A << std::endl;
}