# LogsSpy

LogsSpy is a JUnit5 extension used to assert logs.

## Usage

Sometimes it's a good idea to test logs (as they can be important information for our system). It's not always needed though, as for everything, it depends!

So, here's how to use it:

```java
@UnitTest
@ExtendWith(LogsSpy.class)
class MyTest {

  private final LogsSpy logs;

  public MyTest(LogsSpy logs) {
    this.logs = logs;
  }

  @Test
  void shouldDoStuff() {
    doingStuff();

    logs.shouldHave(Level.INFO, "some stuff");
    logs.shouldHave(Level.DEBUG, "repeated stuff", 5);
    logs.shouldNotHave(Level.ERROR, "this is an error");
  }
}

```
