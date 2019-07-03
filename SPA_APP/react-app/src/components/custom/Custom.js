import React, {Component} from 'react';
import {MapTo} from '@adobe/cq-react-editable-components';

const CustomConfig = {

    emptyLabel: 'Custom',

    isEmpty: function(props) {
        return !props || !props.customTitle || props.customTitle.trim().length < 1;
    }
};

export default class Custom extends Component {
    render() {
    if (this.props.customTitle) {
        return (<div className="custom"> <b> {this.props.customTitle}</b> </div>);
        }
    }
}

MapTo('wknd-events/components/content/custom')(Custom, CustomConfig);