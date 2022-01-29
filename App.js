import logo from "./logo.svg";
import "./App.css";
import React from 'react';

// importação dos pacotes necessários
import { useEffect } from "react";
import axios from "axios";

// configuração da url de comunicação com o backend (aqui você irá usar aquela url copiada)
const api = axios.create({
  baseURL: `http://localhost:8080/conexao-react-servlet/`,
  headers: {
    "Content-type": "application/json",
  },
});

function App() {
  // aqui usamos um Effect que tem a função de executar o seu conteúdo na inicialização do App
  useEffect(() => {
    // aqui definimos a função que irá chamar a requisição na url que configuramos,
    // adicionando o trecho '/MeuServlet' na url
    // com isso, nossa requisição cairá no nosso Servlet
    const chamarRequisicao = async () => {
      const resposta = await api.get(`/MeuServlet`);
      console.log(resposta.data);
    };

    // aqui chamamos a função que acabamos de definir
    chamarRequisicao();
  }, []);

   // aqui vem o resto do código do seu app
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;