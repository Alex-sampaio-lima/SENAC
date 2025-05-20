/* global use, db */
// MongoDB Playground
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.

const database = "vendas";
const collection = "cliente";

// Create a new database.
use(vendas);
// Create a new collection.
db.createCollection(collection);

db.cliente.insertMany([
  {
    codigo: 1,
    nome: "Alexsander Sampaio Lima",
    endereco: "Rua asdrubal gonçalves, 214",
    telefone: {
      celular: "11940264105",
      fixo: "11940264105",
      comercial: "11940264105",
    },
    bairro: "Jardim das flores",
    cidade: "São Paulo",
  },
  {
    codigo: 2,
    nome: "Marcelo de costa Lima",
    endereco: "Rua padre santo, 234",
    telefone: {
      celular: "11944264105",
      fixo: "11940234105",
      comercial: "11944224103",
    },
    bairro: "Jardim são paulo",
    cidade: "Minas Gerais",
  },
]);

// Buscar todos
db.cliente.find();

// Buscar um especifico
db.cliente.find({ cidade: "São Paulo" });

// Buscar com multiplos critérios
db.cliente.find({
  cidade: "São Paulo",
  bairro: "Jardim das flores",
});

// Buscar um especifico com campo aninhado
db.cliente.find({
  "telefone.celular": "11940264105",
});

// Atualizar um campo com updateOne()

db.cliente.updateOne(
  { codigo: 1 }, // filtro
  { $set: { cidade: "São Bernado do Campo" } } // atualização
);
