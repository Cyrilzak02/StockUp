

function Button(props) {
    const buttonstyle = {
        backgroundColor: props.color_option,
        width: props.width,
        height: props.height,
        border: 'none',
        borderRadius: props.borderRadius,
        cursor: 'pointer',
        fontSize: '16px',
        color: props.font_color,
        fontFamily : 'Verdana ',
        type: props.type,
        marginLeft : props.marginLeft,
        marginTop : props.marginTop


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