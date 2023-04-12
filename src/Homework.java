import java.util.ArrayList;
import java.util.List;

// Взяв за основу материал классной работы, написать алгоритм сортировки слиянием для строк
// (используйте метод compareTo()).
public class Homework {

  public static List<Integer> sort(List<Integer> numbers) {
    if (numbers.size() < 2) {
      return numbers;
    }

    // разбить на две половинки
    int mid = numbers.size() / 2;
    List<Integer> left = numbers.subList(0, mid);
    List<Integer> right = numbers.subList(mid, numbers.size());

    System.out.println("=== sort(" + numbers + ") ===");
    System.out.println("left = " + left);
    System.out.println("right = " + right);

    // отсортировать каждую
    left = sort(left);
    right = sort(right);

    // слить две половинки
    return merge(left, right);
  }

  /**
   * Слияние двух отсортированных по возрастанию списков в один
   *
   * @param list1 отсортированный по возрастанию список чисел
   * @param list2 отсортированный по возрастанию список чисел
   * @return отсортированный по возрастанию итоговый список чисел после слияния
   */
  private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
    System.out.println("=== merge(" + list1 + ", " + list2 + ") ===");
    List<Integer> result = new ArrayList<>();
    int i1 = 0;
    int i2 = 0;

    while (i1 < list1.size() && i2 < list2.size()) {
      int first = list1.get(i1);
      int second = list2.get(i2);
      if (first < second) {
        result.add(first);
        ++i1;
      } else {
        result.add(second);
        ++i2;
      }
    }
    while (i1 < list1.size()) {
      result.add(list1.get(i1));
      ++i1;
    }

    while (i2 < list2.size()) {
      result.add(list2.get(i2));
      ++i2;
    }

    System.out.println("result = " + result);
    return result;
  }

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(3);
    numbers.add(1);
    numbers.add(7);
    numbers.add(2);
    numbers.add(5);

    System.out.println(numbers);
    numbers = sort(numbers);
    System.out.println(numbers);
  }
}
