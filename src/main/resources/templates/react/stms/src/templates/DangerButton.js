import React from 'react';
import {useNavigate} from "react-router";

export function DangerButton({screenName, text}) {
    const navigation = useNavigate();
    return(
        <button className="btn btn-danger" onClick={() => {
            navigation(screenName, {replace: true})
        }} style={{marginLeft: "10px"}}>{text}</button>
    )
}

export default DangerButton;