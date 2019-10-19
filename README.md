Todo list application
=====================
​
Zadanie 1
---------
Utwórz REST API będące back-endem dla aplikacji web/mobile będącej listą zadań do wykoanania (todo list)
Funkcjonalność API jest następująca:
  - pobranie listy zadań
  - pobranie konkretnego zadania
  - dodanie nowego zadania
  - edycja istniejącego zadania
  - usunięcie zadania
​
Listę zadań zapisz w sesji użytkownika. Każde zadanie posiada:
  - treść zadania
  - termin wykonania zadania
  - priorytet
  - flaga oznaczajaca wykonanie zadania
  - opcjonalnie: możliwość ustawienia kolejności zadań na wyświetlanej liście
​
W implementacji użyj wzorca Model-View-Controller opartego o Spring MVC.
​
Zadanie 2
---------
Dodaj warstwę utrwalania w bazie danych opartą o Spring Data JPA
​
Zadanie 3
---------
Zmodyfikuj metodę kontolera zwracającą listę zadań o możliwość sortowania wg priorytetu oraz filtrowania wg treści zadania