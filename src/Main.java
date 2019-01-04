import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;


public class Main {

	public static void main(String[] args) throws IOException{
		
		
		Scanner sc = new Scanner(System.in);
		WordCounter wordcounter = new WordCounter();
		String kword = sc.next();
		wordcounter.countKeyword(kword);
		
	}
}
