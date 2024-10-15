import React, { useState, useEffect } from 'react';
import Button from "../Components/Button";
import Popup from "../Components/PopUp";

function CadastroVendas() {
    const [produto, setProduto] = useState('');
    const [quantidade, setQuantidade] = useState(1);
    const [produtosAdicionados, setProdutosAdicionados] = useState([]);
    const [valorTotal, setValorTotal] = useState(0);
    const [produtosDisponiveis, setProdutosDisponiveis] = useState([]);
    const [funcionarioId] = useState(1);
    const [popupMessage, setPopupMessage] = useState('');
    const [isPopupVisible, setIsPopupVisible] = useState(false);

    useEffect(() => {
        fetch('http://localhost:8080/api/produtos/get_all_produto_infos')
            .then(response => response.json())
            .then(data => setProdutosDisponiveis(data))
            .catch(error => console.error('Error fetching products:', error));
    }, []);

    const adicionarProduto = () => {
        const produtoSelecionado = produtosDisponiveis.find(p => p.descricao === produto);
        if (produtoSelecionado) {
            const novoProduto = {
                ...produtoSelecionado,
                quantidade: quantidade
            };

            setProdutosAdicionados([...produtosAdicionados, novoProduto]);
            setValorTotal(valorTotal + (novoProduto.precoUnitario * quantidade));
            setProduto('');
            setQuantidade(1);
        }
    };

    const removerProduto = (id) => {
        const produtosFiltrados = produtosAdicionados.filter(p => p.id !== id);
        const produtoRemovido = produtosAdicionados.find(p => p.id === id);
        setValorTotal(valorTotal - (produtoRemovido.precoUnitario * produtoRemovido.quantidade));
        setProdutosAdicionados(produtosFiltrados);
    };

    const concluirVenda = () => {
        const vendaData = {
            valor: valorTotal,
            data_venda: new Date().toISOString().split('T')[0],
            funcionarioId: funcionarioId,
            produtos: produtosAdicionados.map(produto => ({
                produtoId: produto.id,
                qtd: produto.quantidade
            }))
        };

        fetch('http://localhost:8080/venda/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(vendaData)
        })
            .then(response => {
                if (response.ok) {
                    setPopupMessage('Venda concluída com sucesso!');
                    setProdutosAdicionados([]);
                    setValorTotal(0);
                } else {
                    setPopupMessage('Erro ao concluir venda. Tente novamente.');
                }
                setIsPopupVisible(true);
            })
            .catch(error => {
                console.error('Error sending sale data:', error);
                setPopupMessage('Erro ao enviar dados da venda. Tente novamente.');
                setIsPopupVisible(true);
            });
    };

    const closePopup = () => {
        setIsPopupVisible(false);
    };

    return (
        <div style={{ padding: '20px', backgroundColor: '#2f2f2f', color: 'white' }}>
            <h2>Cadastrar Venda</h2>

            <div style={{ display: 'flex' }}>
                <label style={{ paddingRight: '10px' }}>Produto: </label>
                <select value={produto} onChange={(e) => setProduto(e.target.value)}>
                    <option value="">Selecionar produto</option>
                    {produtosDisponiveis.map((produto) => (
                        <option key={produto.id} value={produto.descricao}>
                            {produto.descricao}
                        </option>
                    ))}
                </select>

                <label style={{ paddingRight: '10px', paddingLeft: '10px' }}>Quantidade: </label>
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
                    <th style={{ border: '1px solid white', padding: '10px' }}>Preço</th>
                    <th style={{ border: '1px solid white', padding: '10px' }}>Excluir</th>
                </tr>
                </thead>
                <tbody>
                {produtosAdicionados.map((produto) => (
                    <tr key={produto.id}>
                        <td style={{ border: '1px solid white', padding: '10px' }}>{produto.id}</td>
                        <td style={{ border: '1px solid white', padding: '10px' }}>{produto.descricao}</td>
                        <td style={{ border: '1px solid white', padding: '10px' }}>{produto.quantidade}</td>
                        <td style={{ border: '1px solid white', padding: '10px' }}>R$ {produto.precoUnitario ? produto.precoUnitario.toFixed(2) : 'N/A'}</td>
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


            {isPopupVisible && <Popup message={popupMessage} onClose={closePopup} />}
        </div>
    );
}

export default CadastroVendas;

