# Digital-Bank-OO: Resilience & Architecture

[![Allure Report CI](https://github.com/luanmarcelseverino/Java-Fintech-Architecture-Compliance-Core/actions/workflows/main.yml/badge.svg)](https://github.com/luanmarcelseverino/Java-Fintech-Architecture-Compliance-Core/actions/workflows/main.yml)
[![pages-build-deployment](https://github.com/luanmarcelseverino/Java-Fintech-Architecture-Compliance-Core/actions/workflows/pages/pages-build-deployment/badge.svg)](https://github.com/luanmarcelseverino/Java-Fintech-Architecture-Compliance-Core/actions/workflows/pages/pages-build-deployment)

Este projeto demonstra uma implementação robusta de um sistema bancário digital, utilizando os pilares da **Programação Orientada a Objetos (POO)em Java**, integrando gestão de dependências com **Maven** e otimização de código com **Lombok**.

### 📊 Relatório de Testes (Allure Report)
Você pode visualizar os resultados detalhados da última execução da pipeline aqui:
**[Visualizar Relatório Online](link)**

### Status do Projeto
O projeto foca em escalabilidade e manutenibilidade, servindo como base para futuras integrações de testes unitários e de integração.

---

## Tech Stack
* **Linguagem:** Java 21
* **Gestão de Dependências:** Maven
* **Bibliotecas:** Lombok
* **IDE:** VS Code
* **DevOps/QA:** GitHub Actions (CI/CD)

## Diferenciais do Projeto
* **Transactional Ledger:** Implementação de um histórico dinâmico que rastreia cada movimentação (Data, Tipo, Valor e Descrição).
* **Boilerplate-Free:** Uso estratégico de **Lombok** para manter as entidades limpas e focadas na regra de negócio.
* **Business Rules Validation:** Validações de saldo e valores para garantir a resiliência das operações financeiras.
* **Scalable Architecture:** Estrutura baseada em Interfaces e Classes Abstratas para alta manutenibilidade.
* **Automated Pipeline:** Integração contínua configurada para validar o build a cada commit.
* **Messaging Architecture:** Simulação de alertas push e notificações críticas de saldo.
* **Object-Oriented Excellence:** Aplicação rigorosa de Abstração, Encapsulamento e Polimorfismo.

## Como executar
1. **Instale as dependências:** `mvn clean install`
2. **Compilação:** O Maven gerará os arquivos `.class` e processará as anotações do Lombok automaticamente.
3. **Execução:** Rode o método `main` localizado em `src/main/java/Main.java`.

---

Dúvidas ou sugestões? Conecte-se comigo no LinkedIn: [in/luanmarcelseverino](https://www.linkedin.com/in/luanmarcelseverino/)