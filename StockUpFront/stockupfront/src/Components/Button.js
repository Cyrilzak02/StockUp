

function Button(props) {
    const buttonstyle = {
        backgroundColor: props.color_option,
        width: props.width,
        height: props.height,
        border: 'none',
        borderRadius: props.borderRadius,
        cursor: 'pointer',
        padding: '10px',
        fontSize: '16px',
        color: props.font_color,
        fontFamily : 'Verdana '
    };

    return (
        <div className="button-div">
            <button style={buttonstyle}>
                {props.text}
            </button>
        </div>
    );
}

export default Button;