# Redirecionamento html:

O código HTML abaixo é uma meta tag que **redireciona automaticamente** o navegador para a URL especificada após um período de tempo definido. Neste caso, o código redireciona imediatamente para a página 'employee/list'.

```html
<meta http-equiv="refresh" content="0; URL='employee/list'">
```

* ```http-equiv="refresh"```: Isso especifica que a página deve ser recarregada ou redirecionada.

* ```content="0; URL='employee/list'"```: Define que o redirecionamento deve ocorrer após 0 segundos (ou seja, imediatamente) e direciona o navegador para a URL 'employee/list'.

Basicamente, ao carregar a página contendo essa meta tag, o navegador irá automaticamente levar o usuário para 'employee/list'. É como dizer "você não precisa estar aqui, vamos direto para 'employee/list'". Bem útil para redirecionamentos rápidos sem precisar de intervenção do usuário. 