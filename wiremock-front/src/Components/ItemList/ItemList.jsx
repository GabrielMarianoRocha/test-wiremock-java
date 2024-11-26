// src/ItemList.js
import React, { useEffect, useState } from "react";
import "./ItemList.css"; // Importando o arquivo CSS

const ItemList = () => {
    const [items, setItems] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    useEffect(() => {
        const apiUrl = "http://localhost:8081/api/v1/items";
        fetch(apiUrl)
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Erro ao buscar os itens");
                }
                return response.json();
            })
            .then((data) => {
                setItems(data);
                setLoading(false);
            })
            .catch((error) => {
                setError(error.message);
                setLoading(false);
            });
    }, []);

    if (loading) {
        return <div className="loading">Carregando...</div>;
    }

    if (error) {
        return <div className="error">Erro: {error}</div>;
    }

    return (
        <div className="item-list-container">
            <h1 className="header">Lista de Itens</h1>
            <ul className="item-list">
                {items.map((item, index) => (
                    <li key={index} className="item">
                        <div className="item-name">{item.name}</div>
                        <div className="item-quantity">{item.quantity}</div>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ItemList;
