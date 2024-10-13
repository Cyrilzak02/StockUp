// Popup.js
import React from 'react';
import Button from "./Button";

function Popup({ message, onClose }) {
    const popupStyles = {
        position: 'fixed',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        background: 'white',
        padding: '20px',
        borderRadius: '10px',
        boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
        zIndex: 1000,
        textAlign: 'center',
    };

    const overlayStyles = {
        position: 'fixed',
        top: 0,
        left: 0,
        right: 0,
        bottom: 0,
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
        zIndex: 999,
    };

    return (
        <>
            <div style={overlayStyles} onClick={onClose} />
            <div style={popupStyles}>
                <p style={{color:"black"}}>{message}</p>
                <Button
                    color_option={"green"}
                    width={"200px"}
                    height={"30px"}
                    text={"Close"}
                    font_color={"White"}
                    borderRadius={"10px"}
                    onClick={onClose}
                />
            </div>
        </>
    );
}

export default Popup;
