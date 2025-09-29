<h1 align=center>
  Projeto de POO: Interface de Gerenciamento
</h1>
<h4>
  No projeto final de Programação Orientada a Objetos foi prposta a criação de uma interface em Java com conexão ao banco de dados com intuito de gerenciar os mesmos. Além do Java, o SQL também foi amplamente 
  utilizado, não só no código fonte em Java mas no script de 
  criação do banco utilizado. Para a organização das classes foi utilizado o modelo MVC (Model-View-Controller), para facilitar a leitura e deixar o código organizado. Na model temos as classes que geram os objetos, a 
  classe que faz conexão com o banco e as
  chamadas DAO (Data Acess Object) que contém as funções e códigos relacionados a captação de dados do banco. Já na controller temos classes com os protótipos das funções criadas na DAO, esse pacote faz uma "ponte" 
  entre a view e a controller. Por último a view que contém
  as telas da interface, no caso deste projeto são 5.
</h4>
<h2>
  View (Telas)
</h2>
<h4>
  Começando pela view como dito antes nela há 4 telas: Menu, Gerenciamento de Clientes, Vendas, Produtos e Relatórios. A tela de menu simplesmente redireciona para as outras telas e fecha completamente o sistema. A 
  tela de clientes, produtos e vendas possuem os botões de Carregar, que preenchem as informações de um dos 3 elementos nos inputs e nas combo boxes, os de Deletar, que deletam um cadastro por ID ou CPF no caso do cliente do banco,
  os de Cadastrar, que cria novos cadastros no banco, o de Atualizar que muda informações de um cadastro no banco por meio de ID ou CPF, a partir das caixas de input e combo boxes e o botão de limpar que apaga todos os campos da tela.
  As demais telas são semelhantes exceto pela tela de Relátorios que apenas imprime cadastros baseados nos filtros disponibilizados
</h4>
<h2>
  Controller
</h2>
<h4>
  Nesta parte estão as chamadas de funções das Telas para a DAO e vice-versa. São códigos simples baseados nas tabelas do banco de dados, então há arquivos de controller para cliente, formas de pagamento, produto entre outros, respeitando o padrão utilizado, MVC
</h4>
<h2>
  Model
</h2>
<h4>
  Por fim na Model temos as classes que representam as entidades que formam os objetos do projeto, assim como na controller, há uma classe para cada tabela do banco basicamente. Aqui há também estão as DAOs, que são as classes com funções para transmitir os dados da 
  tela para o banco de dados. Esses arquivos utilizam o pacote SQL para escrever as querys e realizar os comandos de Cadastro, Exclusão, Atualização e Relátorio em tela
</h4>
<h2>
  Imagens do Sistema
</h2>
<h4>
  Aqui estão as imagens da tela final. Uma library externa foi utilizada para melhorar o design
</h4>
