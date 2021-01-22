import javax.swing.JFrame; // библиотека для работы с окнами (4)
// класс и его название (4)
public class MyStartClass {
    // метод -точка входа (то откуда программа начинает работать) (4)
	public static void main(String[] args) {
		//  Создаём окно с названием в скобочках (4)
		JFrame okno = new JFrame("ЗДЕСЬ СКОРО БУДЕТ КРАСНЫЙ КВАДРАТ");
		// Устанавливаем размеры окна (5)
		okno.setBounds(10,10,1000,700);
		// Устанавливаем очистку памяти при закрытии окна (4)
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Прикрепляем панель с именем MyPanel (4)
		okno.add(new MyPanel("ЗДЕСЬ СКОРО БУДЕТ КРАСНЫЙ КВАДРАТ, НО ЭТО НЕ ТОЧНО"));
		// Делаем окно видимым (4)
		okno.setVisible(true);
	}
}
