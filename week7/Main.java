package pstudio.j061;

import java.uti l.Scanner;

public class Main {
public static void main(Str ing[] args) {
Main Pstudio = new Main();
Pstudio.run();
}

public void run() {
int menu, quit=0;
Scanner s = new Scanner (System. in);
WordCRUD manager = new WordCRUD();

whi le(true) {
System.out.printIn("Menu> 1 Add 2 Edit 3 List 4 Delete O Exit");
menu = s.nextint();
switch(menu) {
case 1: manager. addWord(); break;
case 2: manager.editWord(); break;
case 3: manager. listWord(); break;
case 4: manager. deleteWord(); break;
default: quit = 1;
}
if(quit == 1) break;
}
}
}