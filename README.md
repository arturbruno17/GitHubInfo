<h1 align="center">GitHub Info</h1>
<p align="center">Aplicativo para mostrar dados do GitHub de um usuário</p>

<p align="center">
  <img src="https://img.shields.io/static/v1?label=retrofit&message=2.9.0&color=48B983&style=flat-square"/>
  <img src="https://img.shields.io/static/v1?label=converter-gson&message=2.9.0&color=8296A7&style=flat-square"/>
  <img src="https://img.shields.io/static/v1?label=glide&message=4.11.0&color=25BAA2&style=flat-square"/>
  <img src="https://img.shields.io/static/v1?label=recyclerview&message=1.1.0&color=25BAA2&style=flat-square"/>
  <img src="https://img.shields.io/static/v1?label=hilt&message=1.0.0-alpha02&color=2196F3&style=flat-square"/>
</p>

<p align="center">
 <a href="#-sobre">Sobre</a> •
 <a href="#-screenshots">Screenshots</a> • 
 <a href="#-bibliografia">Bibliografia</a> •
 <a href="#-contribuição">Contribuição</a>
</p>

# 📜 Sobre

Aplicativo que realiza chamadas na API do GitHub e mostra os dados e repositórios de um determinado usuário. O projeto se baseia na arquitetura 
[MVVM](https://developer.android.com/jetpack/guide?hl=pt-br) (Model View ViewModel) e usa algumas bibliotecas para auxiliar em certas funcionalidades:

* Retrofit: integração da API com o aplicativo. Usada juntamente com Gson para converter o JSON em classe de dados.
* Glide: carregamento das imagens vindas da internet.
* Hilt: injeção de dependência de maneira automática.

O aplicativo é simples de usar. Ao entrar no aplicativo, será apresentada uma tela onde você digitará o nome de usuário e apertará em "PESQUISAR". Após apertar o botão, será
exibida uma tela onde será apresentado os dados e repositórios do usuário.

# 📱 Screenshots
<p align="center">
  <img src="https://user-images.githubusercontent.com/59144771/106071612-6bf61a00-60e5-11eb-92a6-7378b5be7fef.jpg" width="30%"/>
  <img src="https://user-images.githubusercontent.com/59144771/106071616-6c8eb080-60e5-11eb-88ba-cadb3a14fd94.jpg" width="30%"/>
</p>

# 📚 Bibliografia
Nesta seção, você encontrará vários links e recursos que falam acerca das bibliotecas e extras utilizados no projeto.

|  Biblioteca   |  Link 	|
|---	|---	|
|   Glide	|   https://bumptech.github.io/glide/	|
|   Retrofit	|  https://square.github.io/retrofit/ 	|
|   Hilt	|  https://dagger.dev/hilt/ 	|

# 🤝 Contribuição
O app foi criado e testado em um dispositivo físico, Redmi Note 9s, mas é disponível para qualquer um que queira contribuir.

Caso tenha alguma ideia de como melhorar o app, realize os seguintes passos:

1. Para contribuir, basta fazer um fork. 
(<https://github.com/arturbruno17/GitHubInfo/fork>)

2. Crie uma branch para sua modificação
(`git checkout -b feature/fooBar`)

3. Faça o commit
(`git commit -am "Add some fooBar"`)

4. Push
(`git push origin feature/fooBar`)

5. Crie um novo *Pull Request*
