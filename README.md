# ForexApp_v1
**Dodać walidacje dla daty - jeśli data jest przyszła występuje ostrzeżenie **
Rodzaj waluty dać jako typ enum

dodanie metody do bazy pobierającej transakcje danego usera


Adnotacja @Component jest jednak bardzo ogólna i nie wskazuje roli, jaką pełni dana klasa. Z tego powodu najczęściej używa się jej specjalizacji w postaci adnotacji:

@Service - klasy warstwy usług,
@Repository - klasy repozytoriów, czyli zbiorów danych, które pod spodem mogą korzystać z kolekcji lub np. dodatkowej warstwy DAO,
@Controller - klasy kontrolerów ze wzorca Model View Controller (MVC).

Adnotacja @SpringBootApplication to w rzeczywistości połączenie trzech innych adnotacji, konkretnie:

@SpringBootConfiguration - wskazanie, że jest to klasa konfiguracji Spring Boota. W projekcie powinna być tylko jedna klasa oznaczona taką adnotacją.
@EnableAutoConfiguration - włącza automatyczną konfigurację. Jeżeli do swojego projektu dodasz np. zależność do projektu Spring MVC, to dzięki tej adnotacji Spring Boot dostarczy domyślną konfigurację, dzięki której będziesz mógł definiować klasy służące do obsługi żądań HTTP przychodzących do aplikacji.
@ComponentScan - wskazuje, że Spring powinien przeszukać projekt w poszukiwaniu klas konfiguracji i komponentów, na podstawie których zostaną utworzone obiekty, które trafią do kontenera wstrzykiwania zależności.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
dodawanie przykladowych bibliotek javy
@Configuration
class AppConfig {
    
    @Bean
    Scanner scanner() {
        return new Scanner(System.in);
    }
}
@Component
class A {
    private Scanner scanner;

    public A(Scanner scanner) {
        this.scanner = scanner;
    }
    //...
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
