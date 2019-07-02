import React, {Component} from 'react';
import {MapTo} from '@adobe/cq-react-editable-components';
require('./Custom.scss');

const CustomConfig = {

    emptyLabel: 'Custom',

    isEmpty: function(props) {
        return !props || !props.customTitle || props.customTitle.trim().length < 1;
    }
};

export default class Custom extends Component {
    render() {
        return (<div className="Custom">
               <h1> {this.props.customTitle} </h1>
            </div>);
    }
}

MapTo('wknd-events/components/content/custom')(Custom, CustomConfig);