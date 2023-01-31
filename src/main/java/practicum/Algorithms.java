package practicum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Algorithms {

    /***
     *
     * В задачах, в которых заранее не оговорен состав символов в строках,
     * строки могут содержать русские и английские буквы,
     * а также пробелы, знаки препинания, кавычки и скобки.
     *
     * Не использовать при решении регулярные выражения, методы стандартных библиотек
     * java.util.Collections, java.util.Arrays, java.lang.Math, а также методы
     * replace и replaceAll, reverce, equals, indexOf, toLowerCase, toUpperCase
     * split, substring из java.lang.String.
     * Можете использовать циклы, условные операторы,
     * простые типы данных и их обертки.
     *
     * Как изменится сложность ваших решений, если убрать
     * ограничения по использованию функций Java API?
     */

    /**
     * Вычислите максимальное, минимальное и среднее число для списка чисел
     * Верните их сумму
     * Список гарантированно содежит элементы
     */
    public static double maxMinAvr(List<Integer> numbers) {
        int max = numbers.get(0);
        int min = numbers.get(0);
        double avg = 0;

        for (int i = 0; i <= numbers.size() - 1; i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
            avg = avg + numbers.get(i);
        }


        avg = avg / numbers.size();

        return min + max + avg;
    }


    /**
     * Найдите второе максимальное значение в массиве,
     * если такого нет, то вернуть первое
     * Массив гарантировано содержит элементы
     */
    public static Integer max2(List<Integer> list) {
        int max1 = list.get(0);
        int max2 = list.get(0);

        for (int i = 0; i <= list.size() - 1; i++) {
            if (list.get(i) > max1) {
                max2 = max1;
                max1 = list.get(i);
            }
        }
        return max2;
    }

    /**
     * Удалите число из массива.
     * Верните массив не содержащий этого элемента,
     * но и не содержащий "пропусков" на месте удаленных элементов
     * Например, если из массива [0, 6, 0 ,5, 0] нужно удалить элемент 0,
     * то возвращаться должен массив содержащий два элемента [6, 5]
     */
    public static int[] removeElementFromArray(int[] numbers, int value) {

        ArrayList<Integer> list = new ArrayList<>();
        int newLength = 0;

        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] != value) {
                newLength++;
                list.add(numbers[i]);
            }
        }
        int[] array = new int[newLength];

        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = list.get(i);
        }
        return array;
    }


    /**
     * Удалите все гласные из строки.
     * Например, "мАма Мыла раму" -> "мм Мл рм"
     */
    public static String removeVowels(String str) {
        Character[] vovels = {'у', 'е', 'ё', 'ы', 'а', 'о', 'э', 'я', 'и', 'ю',
                'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я',
                'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y'
        };
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            boolean contains = false;
            for (Character vovel : vovels) {

                if (str.charAt(i) == vovel) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {

                result += str.charAt(i);
            }
        }
        return result;
    }


    /**
     * Убрать повторяющиеся подряд символы в строке
     * например "ммммоолллокко" -> "молоко"
     * (*) - в этой задаче нужно учитывать сочетания
     * повторяющихся букв разного регистра,
     * при этом в выходной строке остается первая буква,
     * например, "мМммооЛллокКОоо" -> "моЛокО",
     */
    public static String removeDublicates(String str) {
        String result = "";
        boolean nextDublicate = false;
        if (str.length() == 1 || str.length() == 0) {
            return str;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (!nextDublicate) {
                result += ch;
            }
            if (ch == str.charAt(i + 1) || (ch + 32) == str.charAt(i + 1) || (ch - 32) == str.charAt(i + 1)) {
                nextDublicate = true;
            } else nextDublicate = false;
            if (!nextDublicate && i == str.length() - 2) {
                result += str.charAt(i + 1);
            }
        }
        return result;
    }

    /**
     * Сжать строку, удаляя повторяющиеся символы
     * и указывая количество повторов для каждого символа
     * например "мооолооооккооо" -> "м1о3л1о4к2о2"
     */
    public static String zipStr(String str) {

        String result1 = "";
        int counter = 1;

        boolean nextDublicate = false;
        if (str.length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            return str + counter;
        }


        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);

            if (ch == str.charAt(i + 1)
            //        || (ch + 32) == str.charAt(i + 1) || (ch - 32) == str.charAt(i + 1)
            ) {

                nextDublicate = true;

                if (nextDublicate && counter == 1) {
                    result1 += ch;
                    counter++;


                } else if (nextDublicate) {
                    counter++;
                }

            } else {
                if (!nextDublicate && counter == 1) {
                    ch = str.charAt(i);
                    result1 += ch ;
                    result1 += counter; ;
                } else {
                    nextDublicate = false;
                    result1 += counter;
                    counter = 1;
                }
            }


            if (!nextDublicate && i == str.length() - 2) {
                result1 += str.charAt(i + 1);
                result1 += counter;
            }
            if (nextDublicate && i == str.length() - 2) {
          //      result1 += str.charAt(i + 1);
                result1 += counter;
                break;
            }
        }
        return result1;
    }


    /**
     * Выяснить является ли строка палиндромом,
     * то есть  одинаково читается в обоих направлениях.
     * Например, слово "топот" - палиндром, а слово "топор" нет.
     * Строка "А роза упала на лапу Азора" тоже палиндром,
     * а строка "А роза уколола лапу Азора" нет.
     * "A man, a plan, a canal-Panama", тоже палиндром
     * <p>
     * (!) Так как запрещены регулярные выражения
     * и методы преобразования регистра символов из java.lang.String
     * обратите внимание таблицу кодов символов UTF-8
     * (лучше убрать эту подсказку и выдать ее в процессе)
     */
    public static boolean isPalindrom(String str) {
        char[] commas = {'!', '-', ',', '.', '?', '"', '\'', ' ', '\\', '–'};

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            boolean contains = false;
            for (Character vovel : commas) {

                if (str.charAt(i) == vovel) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {

                result += str.charAt(i);
            }
        }
        result = result.toLowerCase();

        int n = result.length();
        for (int i = 0; i < (n / 2); ++i) {
            if (result.charAt(i) != result.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Перевернуть все слова в предложении
     * "Кот, лакал молоко" -> "тоК лакал околом"
     */
    public static String reverseWordsInSentence(String sentence) {

        String reversedString = "";
        int counter = 0;

        if (sentence.length() < 2) {
            return sentence;
        }

        char[] chars = sentence.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'я') {
                counter++;
                boolean simbol = true;


                if (i == chars.length - 2 && chars[i + 1] >= 'A' && chars[i] <= 'я' && counter != 0) {

                    char temp = 0;
                    int start = i - counter + 1, end = i + 1;

                    while (start <= end) {
                        // Swapping the characters
                        temp = chars[start];
                        chars[start] = chars[end];
                        chars[end] = temp;
                        start++;
                        end--;
                    }
                    break;
                }


            } else if (counter != 0) {
                boolean simbol = false;
                char temp = 0;
                int start = i - counter, end = i - 1;

                while (start <= end) {
                    // Swapping the characters
                    temp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = temp;
                    start++;
                    end--;
                }
                counter = 0;
            }

        }
        for (int j = 0; j < chars.length; j++) {
            reversedString += chars[j];
        }


        return reversedString;
    }

    /**
     * Отсортируйте символы в массиве,
     * не используйте дополнительные структуры данных.
     * При вводе массива символов {'c', 'a', 'b'},
     * возвращаться должен тот же отсортированный массив {'a', 'b', 'c'}
     */
    public static char[] sortSymbols(char[] symbols) {

        for (int i = 0; i < symbols.length; i++) {
            char temp;
            for (int j = 0; j < symbols.length; j++) {

                if (symbols[j] > symbols[i]) {
                    temp = symbols[i];
                    symbols[i] = symbols[j];
                    symbols[j] = temp;
                }
            }
        }
        return symbols;
    }


    /**
     * Выясните являются ли две строки анограммами.
     * Строки являются анограммами, если они состоят из одних и тех же букв
     * Например, слова "кот" и "ток" анограммы, а слова "кот" и  "кит" нет.
     */
    public static boolean isAnogramOf(String word, String anogram) {

        int wordMulti = 1;
        int anogramMulti = 1;

        for (int i = 0; i < word.length(); i++) {
            wordMulti = wordMulti * word.charAt(i);
        }

        for (int i = 0; i < anogram.length(); i++) {
            anogramMulti = anogramMulti * anogram.charAt(i);
        }

        if (wordMulti == anogramMulti) {
            return true;
        } else return false;
    }

    /**
     * Выясните, все ли символы в строке встречаются один раз.
     * Если строка содержит повторябщиеся символы,
     * то возвращать false, если не содержит - true
     * Нельзя использовать дополнительные структуры данных.
     * <p>
     * (!) В этой задаче строка может содержать
     * любой символ из таблицы ASCII (127 символов)
     * <p>
     * (!!) Сложность - O(n)
     */

    public static boolean hasUniqueChars(String str) {

        if (str.length() == 0) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 127) {
                return false;
            }
        }

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

}
