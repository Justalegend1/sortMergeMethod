//Сортировка методом слияния, большой массив делится на более маленькие, значения внутри которых потом сравниваются и затем сливаются в в один массив до тех пор, пока массив не останется один с исходными отсортированными числами
public class test {
    public static void main(String[] args) {
        int[] mass = { 13, 3, 8, 1, 15, 2, 3, 7, 4 };
        System.out.print("Исходный массив: ");
        for (int i = 0; i < mass.length; i++)
            System.out.print(mass[i] + " ");
        System.out.println("");
        mass = sort(mass);
        System.out.print("Отсортированный массив: ");
        for (int i = 0; i < mass.length; i++)
            System.out.print(mass[i] + " ");
    }

    public static int[] sort(int x[]) {
        if (x.length == 1) // Создаем рекурсию, которая выполняется до тех пор, пока массив можно разделить
            return x;
        else {
            int half = (int) Math.floor(x.length / 2); // Разбиваем массив пополам
            int halfFirst[] = new int[half]; // первая часть
            int halfSecond[] = new int[x.length - half]; // вторая часть
            for (int i = 0; i < x.length; i++) { // Заполняем новые массивы длиной половина исходного
                if (i < half)
                    halfFirst[i] = x[i];
                else
                    halfSecond[i - half] = x[i];
            }
            halfFirst = sort(halfFirst); // Скармливаем заполненный массив первой части в sort образуя рекурсию
            halfSecond = sort(halfSecond); // Скармливаем заполненный массив второй части в sort образуя рекурсию
            x = sortNextStep(halfFirst, halfSecond); // Отправляем заполненные значениями массивы в следующий метод
            return x;
        }
    }

    public static int[] sortNextStep(int x[], int y[]) {
        int result[] = new int[x.length + y.length]; // Создаем результирующий массив из суммы длин массивов из
                                                     // аргументов
        // метода
        int a = 0, b = 0;
        for (int i = 0; i < x.length + y.length; i++) { // Сравниваем элементы массивов попарно, меняем их местами,
                                                        // заполняем
                                                        // результирующий массив
            if (a == x.length) {
                result[i] = y[b];
                b++;
            } else if (b == y.length) {
                result[i] = x[a];
                a++;
            } else if (x[a] > y[b]) {
                result[i] = y[b];
                b++;
            } else {
                result[i] = x[a];
                a++;
            }
        }
        return result;
    }
}