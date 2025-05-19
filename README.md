## Suporte

### Git 
Links dos vídeos pra aprender a mexer:
Como baixar Git e subir o primeiro repositório pro GitHub: https://youtu.be/lv5a80XgzlI?si=QfxmnZwXFFbzGZtx
Como usar Git e GitHub: https://youtu.be/UBAX-13g8OM?si=XitH7MRuWLdPCmwa

Comandos básicos:

Criar repositório
- git init 
- git add . 
- git commit -m "primeiro commit"
- git branch -M main 
- git remote add origin (junto com o link do repositório) 
- git push -u origin main 

Alterar e Adição
- cd "caminho da sua pasta onde vai ficar o projeto"
- git clone "link do repositorio"
- abre o repositorio clonado no vscode
- git add . (ou caminho do arquivo se for uma alteração)
- git commit -m "alteração"
- git push


### Eclipse
Entre no eclipse e clique em Import Projects, depois General e escolha a opção Existing Projects into Workspace
<img src="/Tutorial/4.png">

Depois na opção select root directory clique em Browse, escolha a pasta que você quer trazer e clique em Finish
<img src="/Tutorial/5.png">

Pronto você importou o projeto. Agora no canto superior esquerdo clica em Help, depois em Install New Software
<img src="/Tutorial/1.png">

Na tela seguinte você clica em Add e coloca WindowBuilder1.19.0Release Latest no nome, na Url você coloca https://download.eclipse.org/windowbuilder/updates/release/latest e depois clique em Add
<img src="/Tutorial/2.png">

Quando você voltar o WindowBuilder já vai aparecer, marca a check box clica em Next até ele começar a baixar e vai dando Next e permissão até ele começar a baixar
<img src="/Tutorial/3.png">

Feito isso, tem que criar o caminho pro JDBC. Clique com o botão esquerdo na workspace depois em Build Path, depois em Configure Build Path. 

<img src="/Tutorial/6.png">

Vá em Libraries e provavelmente já vai ter o JDBC no ClassPath, se tiver apague ele selecionando ele e clicando em Remove. 

<img src="/Tutorial/7.png">

Depois selecione o ModulePath, clique em Add External JARs e coloque o arquivo JDBC. Depois clique em Apply and Close

<img src="/Tutorial/8.png">

Com isso o Eclipse já deve estar configurado

PS: Se acontecer da parte de Source e Design não aparecerem clica com o botão direito no arquivo, vá em Open With e escolha a opção WindowBuilder Editor

<img src="/Tutorial/9.png">

