import React, { useState } from 'react';
import Button from "../Components/Button";
import InputFields from "../Components/InputFields";
import Popup from "../Components/PopUp";

function CadastroVendas() {
    const [produto, setProduto] = useState('');
    const [quantidade, setQuantidade] = useState(1);
    const [produtosAdicionados, setProdutosAdicionados] = useState([]);
    const [valorTotal, setValorTotal] = useState(0);

    const produtosDisponiveis = [
        { id: 'PRD0095', nome: 'farofa yoki', preco: 8.00, categoria: 'Acompanhamentos', validade: '16/10/2024', localizacao: 'Corredor 1, Prateleira B' },
        { id: 'PRD0043', nome: 'manteiga aviação', preco: 11.00, categoria: 'Laticínios', validade: '24/10/2024', localizacao: 'Corredor 2, Prateleira C' },
        { id: 'PRD0021', nome: 'leite botavo', preco: 7.00, categoria: 'Laticínios', validade: '28/10/2024', localizacao: 'Corredor 3, Prateleira A' },
        { id: 'PRD0283', nome: 'iogurte', preco: 2.50, categoria: 'Laticínios', validade: '02/10/2024', localizacao: 'Corredor 4, Prateleira A' }
    ];

    const adicionarProduto = () => {
        const produtoSelecionado = produtosDisponiveis.find(p => p.nome === produto);
        if (produtoSelecionado) {
            const novoProduto = {
                ...produtoSelecionado,
                quantidade: quantidade
            };

            setProdutosAdicionados([...produtosAdicionados, novoProduto]);
            setValorTotal(valorTotal + (novoProduto.preco * quantidade));
            setProduto('');
            setQuantidade(1);
        }
    };

    const removerProduto = (id) => {
        const produtosFiltrados = produtosAdicionados.filter(p => p.id !== id);
        const produtoRemovido = produtosAdicionados.find(p => p.id === id);
        setValorTotal(valorTotal - (produtoRemovido.preco * produtoRemovido.quantidade));
        setProdutosAdicionados(produtosFiltrados);
    };

    const concluirVenda = () => {
        console.log('Venda concluída:', produtosAdicionados);
    };

    return (
        <div style={{ padding: '20px', backgroundColor: '#2f2f2f', color: 'white' }}>
            <h2>Cadastrar Venda</h2>

            <div style={{display: 'flex'}}>
                <label style={{ paddingRight:'10px'}}>Produto: </label>
                <select value={produto} onChange={(e) => setProduto(e.target.value)}>
                    <option value="">Selecionar produto</option>
                    {produtosDisponiveis.map((produto) => (
                        <option key={produto.id} value={produto.nome}>
                            {produto.nome}
                        </option>
                    ))}
                </select>

                <label style={{ paddingRight:'10px', paddingLeft: '10px'}}>Quantidade: </label>
                <input
                    type="number"
                    value={quantidade}
                    onChange={(e) => setQuantidade(Number(e.target.value))}
                    min="1"
                />

                <Button
                    marginLeft={"50px"}
                    color_option={"black"}
                    width={"200px"}
                    height={"30px"}
                    text={"Adicionar Produto"}
                    font_color={"White"}
                    borderRadius={"10px"}
                    onClick={adicionarProduto}
                />
            </div>

            <table style={{ width: '100%', marginTop: '20px', borderCollapse: 'collapse', backgroundColor: '#1f1f1f', color: 'white' }}>
                <thead>
                    <tr>
                        <th style={{ border: '1px solid white', padding: '10px' }}>ID</th>
                        <th style={{ border: '1px solid white', padding: '10px' }}>Nome Produto</th>
                        <th style={{ border: '1px solid white', padding: '10px' }}>Quantidade</th>
                        <th style={{ border: '1px solid white', padding: '10px' }}>Categoria</th>
                        <th style={{ border: '1px solid white', padding: '10px' }}>Preço</th>
                        <th style={{ border: '1px solid white', padding: '10px' }}>Data Validade</th>
                        <th style={{ border: '1px solid white', padding: '10px' }}>Localização no Armazém</th>
                        <th style={{ border: '1px solid white', padding: '10px' }}>Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    {produtosAdicionados.map((produto) => (
                        <tr key={produto.id}>
                            <td style={{ border: '1px solid white', padding: '10px' }}>{produto.id}</td>
                            <td style={{ border: '1px solid white', padding: '10px' }}>{produto.nome}</td>
                            <td style={{ border: '1px solid white', padding: '10px' }}>{produto.quantidade}</td>
                            <td style={{ border: '1px solid white', padding: '10px' }}>{produto.categoria}</td>
                            <td style={{ border: '1px solid white', padding: '10px' }}>R$ {produto.preco.toFixed(2)}</td>
                            <td style={{ border: '1px solid white', padding: '10px' }}>{produto.validade}</td>
                            <td style={{ border: '1px solid white', padding: '10px' }}>{produto.localizacao}</td>
                            <td style={{ border: '1px solid white', padding: '10px' }}>
                                <Button
                                    color_option={"red"}
                                    width={"100px"}
                                    height={"30px"}
                                    text={"Excluir"}
                                    font_color={"White"}
                                    borderRadius={"10px"}
                                    onClick={() => removerProduto(produto.id)}
                                />
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>

            <div style={{ marginTop: '20px' }}>
                <p><strong>Valor Total: R$ {valorTotal.toFixed(2)}</strong></p>
                <div style={{ float: 'right' }}>
                    <Button
                        color_option={"green"}
                        width={"200px"}
                        height={"40px"}
                        text={"Concluir Venda"}
                        font_color={"White"}
                        borderRadius={"10px"}
                        onClick={concluirVenda}
                    />
                </div>
            </div>
        </div>
    );
}

export default CadastroVendas;
