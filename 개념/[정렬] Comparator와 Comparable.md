

# ✅ 요약

### Comparable

- 인터페이스를 구현한 객체 스스로에게 한 가지 **기본 정렬 규칙을 설정**하는 목적으로 사용
- **정렬의 기준이 되는 메서드를 정의**한다.

### Comparator

- 인터페이스를 구현한 클래스는 정렬 규칙 그 자체를 의미
- **기본 정렬 규칙과 다르게 원하는대로 정렬 순서를 지정**하고 싶을 때 사용

# Comparable

- 인터페이스
- 정렬 수행 시 **정렬의 기준이 되는 메서드를 정의**한다.
    - 예를 들어, member라는 객체에 이름(String), 나이(int)라는 속성이 있다면 무엇으로 member를 정렬해야 할 까?
    - 우리는 이때 Comparable을 통해  정렬 **기준이 되는 속성을 정할 수 있다**.
- Java에서 제공되는 정렬 가능한 클래스는 모두 Comparable 인터페이스를 구현하고 있다.
    - == Comparable 인터페이스를 구현하는 객체는 **고정적인 정렬규칙을 갖는다**.
- compareTo() 메서드를 오버라이드하여 구현한다.

### compareTo()

- 정렬 규칙을 정하는 메서드
- 리턴값
    - 현재객체 < 매개변수 : 음수
    - 현재객체 == 매개변수 : 0
    - 현재객체 > 매개변수 : 양수
- 양수인 경우 두 객체의 자리가 바뀐다.

# Comparator

- **기본 정렬 기준과 다르게** 정렬하고 싶을 때 사용하는 인터페이스
- 주로 내림차순으로 정렬할 때 많이 사용한다.
- compare() 메서드를 오버라이드하여 구현한다.

### compare(x, y)

- 리턴값
    - x < y : 음수
    - x == y : 0
    - x > y : 양수
- 양수인 경우 두 객체의 자리가 바뀐다.
    - Integer.compare(x, y) : 오름차순
    - Integer.compare(y, x) : 내림차순
- 두 번째 인자로 Comparator 인터페이스를 받는 경우

```jsx
// 익명클래스 이용하는 방법
Comparator<Point> myComparator = new Comparator<Point>() {
  @Override
  public int compare(Point p1, Point p2) { 
		if (p1.x > p2.x) {
      return 1; // x에 대해서는 오름차순
    }
    else if (p1.x == p2.x) {
      if (p1.y < p2.y) { // y에 대해서는 내림차순
        return 1;
      }
    }
    return -1;
 }
};

List<Point> pointList = new ArrayList<>();
pointList.add(new Point(x, y));
Collections.sort(pointList, myComparator);
```
