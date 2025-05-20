import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pedido } from './pedido';

@Injectable({
  providedIn: 'root'
})

export class PedidoService {

  apiUrl = 'http://localhost:3000/pedidos';

  constructor(private httpClient: HttpClient) { }
  public resultado: number = 0;

  getAllPedidos() {
    return this.httpClient.get<Pedido[]>(this.apiUrl);
  }

  incrementaId(): number {
    let novoId: number = 0;
    const pedido = this.httpClient.get<Pedido[]>(this.apiUrl).subscribe({
      next: (pedidos) => {
        const ultimaPos = pedidos.length - 1;
        // let ultimoID = pedidos[ultimaPos].id;
        // console.log("Id Atual", ultimoID);
        // novoId = ultimoID + 1;
        console.log("Novo Id: " + novoId);
        this.resultado = novoId;
      }
    });
    console.log("SE PASSAR AQUI DEU CERTO", this.resultado);

    return this.resultado;
  }

  postPedido(pedido: Omit<Pedido, 'id' | 'created_at' | 'updated_at'>): Observable<Pedido> {
    

    const pedidoCompleto = {
      ...pedido,
      created_at: new Date().toISOString(),
      updated_at: new Date().toISOString()
    };

    console.log('Payload sendo enviado:', pedidoCompleto);

    return this.httpClient.post<Pedido>(this.apiUrl, pedidoCompleto);
  }



  // postPedido(pedido: Pedido): Observable<Pedido[]> {
  //   return this.httpClient.post<Pedido[]>(this.apiUrl, pedido);
  // }



};
