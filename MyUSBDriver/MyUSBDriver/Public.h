/*++

Module Name:

    public.h

Abstract:

    This module contains the common declarations shared by driver
    and user applications.

Environment:

    user and kernel

--*/

//
// Define an Interface Guid so that app can find the device and talk to it.
//

DEFINE_GUID (GUID_DEVINTERFACE_MyUSBDriver,
    0xa8f46fda,0x2bfb,0x425f,0xa8,0xc7,0x1f,0x55,0x32,0x4e,0x51,0xb4);
// {a8f46fda-2bfb-425f-a8c7-1f55324e51b4}
