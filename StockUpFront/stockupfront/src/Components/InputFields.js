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
        fontFamily : 'Verdana ',
        marginLeft : '50px',
        marginTop  : '10px'
    };
    const label = {
        color: props.title_color,
        position: 'relative'
    }



    return (
        <div style={{width: "50%" , marginLeft : props.marginLeft , marginTop : props.marginTop}} >
           <label style={label}>{props.title}</label><br/>
            <input style={inputstyle} type={props.type} id={props.id} onChange={props.onChange}/>
        </div>
    );
}

export default InputFields;