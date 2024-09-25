function InputFields(props) {
    const inputstyle = {
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
        <div className="input-div">
           <label>{props.title}</label>
            <input style={inputstyle} type={props.type} id={props.id}/>
        </div>
    );
}

export default InputFields;