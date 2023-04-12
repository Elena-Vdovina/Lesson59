import java.util.ArrayList;
import java.util.List;

// Взяв за основу материал классной работы, написать алгоритм сортировки слиянием для строк
// (используйте метод compareTo()).
public class Homework {

  public static List<String> sort(List<String> lines) {
    if (lines.size() < 2) {
      return lines;
    }

    // разбить на две половинки
    int mid = lines.size() / 2;
    List<String> left = lines.subList(0, mid);
    List<String> right = lines.subList(mid, lines.size());

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
  private static List<String> merge(List<String> list1, List<String> list2) {
    List<String> result = new ArrayList<>();
    int i1 = 0;
    int i2 = 0;

    while (i1 < list1.size() && i2 < list2.size()) {
      String first = list1.get(i1);
      String second = list2.get(i2);
      if (first.compareToIgnoreCase(second) < 0) {
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
    return result;
  }

  public static void main(String[] args) {
    List<String> lines = new ArrayList<>();
    lines.add("красный");
    lines.add("оранжевый");
    lines.add("желтый");
    lines.add("зеленый");
    lines.add("голубой");
    lines.add("синий");
    lines.add("фиолетовый");

    System.out.println(lines);
    lines = sort(lines);
    System.out.println("result = " + lines);
  }
}
