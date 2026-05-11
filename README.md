# ⛪ Gestão de Visitantes - Igreja

Este sistema foi desenvolvido sob medida para a Assembleia de Deus - Área 7, focado em modernizar o acolhimento de visitantes e a gestão da comunicação interna (mural de avisos) para resolver o problema de falta de comunicação e de eventos mal avisados na igreja.

🛠️ O que foi implementado 
1. Gestão de Visitantes e Famílias
Entidades Relacionadas: Implementámos um relacionamento @OneToMany entre Visitante e Familiar, permitindo que um visitante principal registe todos os seus acompanhantes de uma só vez.

CRUD Completo: Funcionalidades de Criar, Ler, Atualizar e Eliminar com interface dinâmica.

Lógica de Edição: O formulário de edição reconstrói automaticamente a lista de familiares para permitir ajustes rápidos.

2. Relatório Excel Inteligente (Apache POI)
Filtro Automático: O sistema gera relatórios apenas com os dados desde o último domingo, ideal para a entrega ao Pastor após o culto.

Hierarquia Visual: Visitantes aparecem em destaque (Negrito) e familiares logo abaixo com o símbolo ↳ e o seu respetivo parentesco.

Regras de Negócio:

Destaque: Células de pessoas não-evangélicas são pintadas de amarelo para atenção especial do ministério.

Resumo: O ficheiro inclui uma somatória automática no final: Total de Visitantes, Total de Familiares e Público Geral.

3. Mural de Informativos
Publicação em Tempo Real: Sistema de avisos para a página inicial com título e mensagem.

Edição Simplificada: Possibilidade de corrigir avisos publicados sem precisar de os eliminar e criar novamente.

4. Interface e Experiência do Utilizador 
Design: Cores baseadas no azul marinho institucional (#1a3a5a), com botões de ação em cores padrão (verde, amarelo, vermelho).

Feedback Profissional: Substituímos os alertas nativos do browser pelo SweetAlert2, eliminando mensagens que mostram o endereço do host.

Responsividade: site adaptavel para celulares,telefones e computadores.

💻 Tecnologias Utilizadas
Linguagem: Java 21

Framework: Spring Boot (Data JPA, Security, Web)

Base de Dados: PostgreSQL

Frontend: HTML5, CSS3 (Bootstrap 5) e JavaScript Vanila

Biblioteca de Excel: Apache POI 5.x

Alertas: SweetAlert2

🚀 Como Executar
Clone o repositório.

Certifique-se de que tem o Maven instalado.

Execute o comando: ./mvnw spring-boot:run

Aceda a: http://localhost:8080

🏗️ Estrutura de Pastas Relevante:
src/main/java/com/igreja/.../model: Entidades Visitante, Familiar e Informativo.

src/main/java/com/igreja/.../service: ExportarService.java (Lógica do Excel).

src/main/resources/templates: Páginas HTML customizadas.
