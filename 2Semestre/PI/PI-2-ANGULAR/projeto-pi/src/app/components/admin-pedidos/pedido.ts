export interface Pedido {
    id: number;
    tipo_pedido: string;
    forma_pagamento: string;
    valor_total: number;
    status: string;
    observacoes: string;
    cliente_id: number;
    created_at: string;
    updated_at: string;
}


