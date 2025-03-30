package ProgramacionIII.TP2_1_Arboles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class BinaryTreeChar {
    private TreeNodeChar root;

    public BinaryTreeChar(TreeNodeChar rootNode) {
        this.root = rootNode;
    }

    public BinaryTreeChar() {
        this.root = null;
    }

    public void add(Character value) {
        if (this.root == null) {
            this.root = new TreeNodeChar(value);
        } else {
            this.add(this.root, value);
        }
    }

    private void add(TreeNodeChar actual, Character value) {
        if (actual.getLeft() == null) {
            actual.setLeft(new TreeNodeChar(value));
        } else if (actual.getRight() == null) {
            actual.setRight(new TreeNodeChar(value));
        }
    }

    /* Ejercicio 5
    Dado un árbol binario donde todos los nodos poseen un carácter, de manera que cada rama del
    árbol contiene una palabra, implementar un algoritmo que busque y retorne todas las palabras
    que posea exactamente N vocales (ni más ni menos). Por ejemplo, para el siguiente árbol, con
    una entrada de N = 1, el algoritmo debería retornar [“MAL”]. En cambio, para un N = 2, debería
    retornar [“MANA”, “MANO”, “MISA”]. */
    public List<String> searchVowelWords(int cantVowels) {
        List<String> result = new ArrayList<String>();
        List<Character> currentWord = new ArrayList<Character>();
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        searchVowelWords(this.root, result, cantVowels, vowels, currentWord);
        return result;
    }

    private void searchVowelWords(TreeNodeChar node, List<String> result, int cantVowels, Set<Character> vowels, List<Character> currentWord) {
        if (node != null) {
            currentWord.add(node.getValue());
            if (node.getLeft() == null && node.getRight() == null) {
                int manyVowels = howManyVowels(currentWord, vowels);
                if (manyVowels == cantVowels) {
                    result.add(convertListToString(currentWord));
                }
            } else {
                searchVowelWords(node.getLeft(), result, cantVowels, vowels, currentWord);
                searchVowelWords(node.getRight(), result, cantVowels, vowels, currentWord);
            }
            currentWord.remove(currentWord.size() - 1);
        }
    }

    private int howManyVowels(List<Character> currentWord, Set<Character> vowels) {
        int cantVowels = 0;
        for (Character c : currentWord) {
            if (vowels.contains(c)) {
                cantVowels++;
            }
        }
        return cantVowels;
    }

    private String convertListToString(List<Character> currentWord) {
        StringBuilder sb = new StringBuilder();
        for (Character c : currentWord) {
            sb.append(c);
        }
        return sb.toString();
    }
}

