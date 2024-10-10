# Convenção de Nomenclatura do Spring Data JPA

O **Spring Data JPA** é extremamente poderoso quando se trata de gerar consultas baseadas em <u>nomes de métodos</u>. Essa funcionalidade é chamada de **Derived Query Methods**. Você define métodos na interface do repositório seguindo certas convenções de nomenclatura, e o Spring cria **automaticamente** a implementação desses métodos para você:

```java
public List<Employee> findAllByOrderByLastNameAsc();
```

* findAllBy:

    * findAll: Indica que queremos buscar todos os registros da entidade Employee.

    * By: Define o início da cláusula que especifica condições para a consulta. No caso deste método, não há uma condição especificada (como ByLastName, ByFirstName, etc.), então ele busca todos os registros.

    * OrderBy: Esta parte do nome do método especifica que os resultados devem ser ordenados. OrderBy é seguido pelo campo que deve ser usado para ordenação.

        * LastName: Especifica o campo pelo qual queremos ordenar os registros, que neste caso é lastName.

        * Asc: Define a direção da ordenação como ascendente (ascendente do inglês, Ascending). Se fosse Desc, a ordenação seria descendente.

Quando você chama ```findAllByOrderByLastNameAsc()```, o Spring Data JPA gera e executa uma consulta SQL equivalente a algo como:

```sql
SELECT * FROM Employee ORDER BY last_name ASC;
```
