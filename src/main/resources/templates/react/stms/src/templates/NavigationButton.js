import React from 'react';
import Button from 'react';
import {useNavigate} from "react-router";

export function NavigationButton({screenName, text}) {
    const navigation = useNavigate();
    return (
        <div className="ui-button">
            <button className="beautiful-button" onClick={() =>
                navigation(screenName, {replace: true})
            }>{text}</button>
        </div>
    )
}

export default NavigationButton;
